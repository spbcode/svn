package springmvcintegrationwebsockets.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvcintegrationwebsockets.database.*;
import springmvcintegrationwebsockets.model.AttendeeRegistration;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class RegistrationService {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationService.class);

    private final AttendeeTicketRepository attendeeTicketRepository;
    private final DiscountCodeRepository discountCodeRepository;
    private final PricingCategoryRepository pricingCategoryRepository;
    private final TicketPriceRepository ticketPriceRepository;
    private final TicketTypeRepository ticketTypeRepository;

    public RegistrationService(AttendeeTicketRepository attendeeTicketRepository,
                               DiscountCodeRepository discountCodeRepository,
                               PricingCategoryRepository pricingCategoryRepository,
                               TicketPriceRepository ticketPriceRepository,
                               TicketTypeRepository ticketTypeRepository) {
        this.attendeeTicketRepository = attendeeTicketRepository;
        this.discountCodeRepository = discountCodeRepository;
        this.pricingCategoryRepository = pricingCategoryRepository;
        this.ticketPriceRepository = ticketPriceRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public void register(AttendeeRegistration registration) {
        LOG.debug("Registration received for: {}", registration.getEmail());

        Attendee attendee = createAttendee(registration);
        TicketPrice ticketPrice = getTicketPrice(registration);
        Optional<DiscountCode> discountCode = discountCodeRepository.findByCode(registration.getDiscountCode());

        AttendeeTicket attendeeTicket = new AttendeeTicket();
        attendeeTicket.setTicketCode(UUID.randomUUID().toString());
        attendeeTicket.setAttendee(attendee);
        attendeeTicket.setTicketPrice(ticketPrice);
        attendeeTicket.setDiscountCode(discountCode.orElse(null));
        attendeeTicket.setNetPrice(ticketPrice.getBasePrice().subtract(discountCode.map(DiscountCode::getAmount).orElse(BigDecimal.ZERO)));

        attendeeTicketRepository.save(attendeeTicket);
        LOG.debug("Registration saved, ticket code: {}", attendeeTicket.getTicketCode());
    }

    private Attendee createAttendee(AttendeeRegistration registration) {
        Attendee attendee = new Attendee();
        attendee.setFirstName(registration.getFirstName());
        attendee.setLastName(registration.getLastName());
        attendee.setEmail(registration.getEmail());
        attendee.setPhoneNumber(StringUtils.trimToNull(registration.getPhoneNumber()));
        attendee.setTitle(StringUtils.trimToNull(registration.getTitle()));
        attendee.setCompany(StringUtils.trimToNull(registration.getCompany()));
        return attendee;
    }

    private TicketPrice getTicketPrice(AttendeeRegistration registration) {
        TicketType ticketType = ticketTypeRepository.findByCode(registration.getTicketType())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ticket type: " + registration.getTicketType()));

        PricingCategory pricingCategory = pricingCategoryRepository.findByDate(LocalDate.now())
                .or(() -> pricingCategoryRepository.findByCode("L"))
                .orElseThrow(() -> new EntityNotFoundException("Cannot determine pricing category"));

        return ticketPriceRepository.findByTicketTypeAndPricingCategory(ticketType, pricingCategory)
                .orElseThrow(() -> new EntityNotFoundException("Cannot determine ticket price for ticket type '" + ticketType.getCode() + "' and pricing category '" + pricingCategory.getCode() + "'"));
    }
}
