package com.coderelated.lld.bookmysow;

public class MovieCrew {

    enum CrewType{
        PRODUCER("producer"),
        DIRECTOR("director"),
        MUSICDIRECTOR("music director"),
        CHOREOGRAPHER("choreographer");
        private String typename;

        CrewType(String typename) {
            this.typename = typename;
        }

        public String getTypename() {
            return typename;
        }
    }

    private CrewType crewType;
    private String name;
}
