package ru.tunkoff.fintech.qa;

public enum Country {
    RUSSIA("Россия", true),
    USA("США", true),
    GERMANY("Германия", false),
    FRANCE("Франция", true),
    NORTH_KOREA("Северная Корея", false);

    private final String ruName;
    private final boolean isOpen;

    Country(final String ruName, final boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.ruName + ")";
    }

    public static Country getByRuName(final String ruName) throws NoSuchCountryException {
        Country output = null;
        for (Country i : Country.values()) {
            if (i.ruName.equals(ruName)) {
                output = i;
            }
        }
        if (output == null) {
            throw new NoSuchCountryException();
        } else {
            return output;
        }
    }
}
