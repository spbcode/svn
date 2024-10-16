package guru.springframework.javastreams;

import guru.springframework.chess.Player;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractise {

    public static void main(String args[]){
        Stream<Player> playerStream = Stream.of(new Player("p1"),
                new Player("p2"),
                new Player("p3"));
        playerStream.collect(Collectors.toList()).stream().filter(p->!p.getName().equals("p1")).forEach(p-> System.out.println(p.getName()));
    }

}
