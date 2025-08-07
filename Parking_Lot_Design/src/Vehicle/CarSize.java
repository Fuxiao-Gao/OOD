package Vehicle;

public enum CarSize {
    MEDIUM {
        @Override
        public String toString() {return "Medium Size";}
    },
    SMALL {
        @Override
        public String toString() {return "Small Size";}
    },
    LARGE {
        @Override
        public String toString() {return "Large Size";}
    }
}
