//package org.translation;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Main class for this program.
// * Complete the code according to the "to do" notes.<br/>
// * The system will:<br/>
// * - prompt the user to pick a country name from a list<br/>
// * - prompt the user to pick the language they want it translated to from a list<br/>
// * - output the translation<br/>
// * - at any time, the user can type QUIT to QUIT the program<br/>
// */
//public class Main {
//
//    public static final String QUIT = "QUIT";
//
//    /**
//     * This is the main entry point of our Translation System!<br/>
//     * A class implementing the Translator interface is created and passed into a call to runProgram.
//     * @param args not used by the program
//     */
//    public static void main(String[] args) {
//        Translator translator = new JSONTranslator();
//        runProgram(translator);
//    }
//
//    /**
//     * This is the method which we will use to test your overall program, since
//     * it allows us to pass in whatever translator object that we want!
//     * See the class Javadoc for a summary of what the program will do.
//     * @param translator the Translator implementation to use in the program
//     */
//    public static void runProgram(Translator translator) {
//        while (true) {
//
//            String country = promptForCountry(translator);
//            if (QUIT.equals(country)) {
//                break;
//            }
//            CountryCodeConverter cConverter = new CountryCodeConverter();
//            String cCode = cConverter.fromCountry(country);
//
//            String language = promptForLanguage(translator, cCode);
//            LanguageCodeConverter languageConverter = new LanguageCodeConverter();
//            String langCode = languageConverter.fromLanguage(language);
//
//            if (QUIT.equals(language)) {
//                break;
//            }
//
//            System.out.println(country + " in " + language + " is " + translator.translate(cCode, langCode));
//            System.out.println("Press enter to continue or quit to exit.");
//            Scanner s = new Scanner(System.in);
//            String textTyped = s.nextLine();
//
//            if (QUIT.equals(textTyped)) {
//                break;
//            }
//        }
//    }
//
//    // Note: CheckStyle is configured so that we don't need javadoc for private methods
//    private static String promptForCountry(Translator translator) {
//
//        List<String> countries = translator.getCountries();
//        CountryCodeConverter converter = new CountryCodeConverter();
//        List<String> countriesByName = new ArrayList<>();
//
//        for (String country : countries) {
//            String code = converter.fromCountryCode(country);
//            countriesByName.add(code);
//        }
//        Collections.sort(countriesByName);
//
//        for (String string : countriesByName) {
//            System.out.println(string);
//        }
//
//        System.out.println("select a country from above:");
//
//        Scanner s = new Scanner(System.in);
//        return s.nextLine();
//
//    }
//
//    // Note: CheckStyle is configured so that we don't need javadoc for private methods
//    private static String promptForLanguage(Translator translator, String country) {
//
//        List<String> lang = translator.getCountryLanguages(country);
//        LanguageCodeConverter converter = new LanguageCodeConverter();
//        List<String> languagesByName = new ArrayList<>();
//
//        for (String language : lang) {
//            languagesByName.add(converter.fromLanguageCode(language));
//        }
//        Collections.sort(languagesByName);
//
//        for (String string : languagesByName) {
//            System.out.println(string);
//        }
//
//        System.out.println("select a language from above:");
//
//        Scanner s = new Scanner(System.in);
//        return s.nextLine();
//    }
//}
package org.translation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for this program.
 * Complete the code according to the "to do" notes.<br/>
 * The system will:<br/>
 * - prompt the user to pick a country name from a list<br/>
 * - prompt the user to pick the language they want it translated to from a list<br/>
 * - output the translation<br/>
 * - at any time, the user can type quit to quit the program<br/>
 */
public class Main {

    /**
     * This is the main entry point of our Translation System!<br/>
     * A class implementing the Translator interface is created and passed into a call to runProgram.
     * @param args not used by the program
     */
    public static void main(String[] args) {
        Translator translator = new JSONTranslator();
        runProgram(translator);
    }

    /**
     * This is the method which we will use to test your overall program, since
     * it allows us to pass in whatever translator object that we want!
     * See the class Javadoc for a summary of what the program will do.
     * @param translator the Translator implementation to use in the program
     */
    public static void runProgram(Translator translator) {

        final String quit = "quit";

        while (true) {
            String country = promptForCountry(translator);
            if (country.equals(quit)) {
                break;
            }

            CountryCodeConverter cConverter = new CountryCodeConverter();
            String cCode = cConverter.fromCountry(country);

            String lang = promptForLanguage(translator, cCode);
            LanguageCodeConverter langConverter = new LanguageCodeConverter();
            String languageCode = langConverter.fromLanguage(lang);

            if (lang.equals(quit)) {
                break;
            }

            System.out.println(country + " in " + lang + " is " + translator.translate(cCode, languageCode));
            System.out.println("Press enter to continue or quit to exit.");
            Scanner s = new Scanner(System.in);
            String textTyped = s.nextLine();

            if (quit.equals(textTyped)) {
                break;
            }
        }
    }

    // Note: CheckStyle is configured so that we don't need javadoc for private methods
    private static String promptForCountry(Translator translator) {

        List<String> countries = translator.getCountries();
        CountryCodeConverter converter = new CountryCodeConverter();
        List<String> cName = new ArrayList<>();

        for (String country : countries) {
            String code = converter.fromCountryCode(country);
            cName.add(code);
        }
        Collections.sort(cName);

        for (String string : cName) {
            System.out.println(string);
        }

        System.out.println("select a country from above:");

        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    // Note: CheckStyle is configured so that we don't need javadoc for private methods
    private static String promptForLanguage(Translator translator, String country) {

        List<String> lang = translator.getCountryLanguages(country);
        LanguageCodeConverter converter = new LanguageCodeConverter();
        List<String> langName = new ArrayList<>();

        for (String string : lang) {
            langName.add(converter.fromLanguageCode(string));
        }
        Collections.sort(langName);

        for (String string : langName) {
            System.out.println(string);
        }

        System.out.println("select a language from above:");

        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}

