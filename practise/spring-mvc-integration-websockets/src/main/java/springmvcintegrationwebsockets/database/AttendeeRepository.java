package springmvcintegrationwebsockets.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
}
