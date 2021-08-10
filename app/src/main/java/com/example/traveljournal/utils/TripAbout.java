package com.example.traveljournal.utils;

public class TripAbout {

    public static final String PARIS =
            "Paris hardly needs an introduction. Europe’s most famous capital has an uncanny " +
            "ability to stay both relevant and iconic. Whether you choose to tick off all the " +
            "famous attractions, or spend the day soaking up the culture at a small Parisian " +
            "brasserie, you’ll most likely be plotting your return before you’ve even departed.";

    public static final String AMSTERDAM =
            "Amsterdam’s famous canal system, quaint architecture, esteemed museums, surplus of " +
            "cyclists, and infectiously hedonistic lifestyle make this one of the most popular " +
            "European capital cities to visit. Its location and great rail connections also make " +
            "it a perfect starting point for a Eurail journey.";

    public static final String ATHENS =
            "Walking through Athens is like walking through thousands of years of history. " +
            "Ancient monuments dripping with history stand alongside everyday buildings, often " +
            "before a chaotic backdrop. Though the city is overwhelming, it’s cleaning up its act" +
            ". Many view a visit to the Greek capital as a historical pilgrimage.";

    public static final String BERLIN =
            "The German capital has become one of the continent’s most iconic cities. A somber " +
            "history has given way to one of Europe’s foremost creative hubs. Parties run through" +
            " the weekend and through to Monday lunchtime, cafés overflow with freelancers and " +
            "buzz with startup meetings, and the streets pulsate with an energy and historical " +
            "legacy that’s hard not to love.";

    public static final String BUDAPEST =
            "Budapest still feels like a sleeping giant waiting to be discovered as Europe’s next" +
            " big city. Stunning architecture, vibrant nightlife, a young and creative food and " +
            "coffee scene, and an intriguing east-meets-west history, all set along the sparkling" +
            " Danube, make this a truly spectacular destination to visit.";

    public static final String COPENHAGEN =
            "The Danish capital occupies an interesting position on the coastal islands of Amager" +
            " and Zealand. It’s packed full of fascinating history and beautiful Renaissance-era " +
            "castles and buildings. But there’s also a modern edge to Copenhagen, which makes it " +
            "one of the most progressive and exciting European capital cities to visit.";

    public static final String LISBON =
            "Lisbon has earned a reputation as one of Europe’s party capitals. Although this may " +
            "be true, there’s a lot more to this city than all-night revelry. History, " +
            "architecture, food, culture, and stunning views combine to make this a truly " +
            "memorable destination to visit on a rail journey through Europe.";

    public static final String LJUBLJANA =
            "What the small Slovenian capital lacks in size, it more than makes up for in charm. " +
            "The beautiful pedestrianized inner city, set along the Ljubljanica River, buzzes day" +
            " and night. There are vibrant bars, cafés, and restaurants. The imposing castle on " +
            "the hill above sets a medieval theme that follows you through the quaint streets of " +
            "this absorbing European capital.";

    public static final String MADRID =
            "The Spanish capital appears to be in a constant battle with Barcelona for the title " +
            "of Spain’s coolest city. But Madrid still has the advantage when it comes to stately" +
            " capital city presence. Pristine parks, impressive museums, classic architecture, " +
            "and a burgeoning creative scene make this one of Europe’s more established and " +
            "intriguing destinations.";

    public static final String ROME =
            "You’re probably already familiar with the Italian capital’s historical significance." +
            " But there’s nothing that can beat a walk through the often chaotic yet always " +
            "fascinating streets of Rome. History is hiding around every corner, and a visit to " +
            "the city has the ability to bring it all to life like few others can.";

    public static String getTripAbout(String name) {
        switch (name.toUpperCase()) {
            case "PARIS":
                return PARIS;
            case "AMSTERDAM":
                return AMSTERDAM;
            case "ATHENS":
                return ATHENS;
            case "BERLIN":
                return BERLIN;
            case "BUDAPEST":
                return BUDAPEST;
            case "COPENHAGEN":
                return COPENHAGEN;
            case "LJUBLJANA":
                return LJUBLJANA;
            case "LISBON":
                return LISBON;
            case "MADRID":
                return MADRID;
            case "ROME":
                return ROME;
            default:
                return "No details available.";
        }
    }
}
