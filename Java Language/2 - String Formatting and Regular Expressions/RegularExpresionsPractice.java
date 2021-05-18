import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresionsPractice {

    /* 
        This was coded using VS-Code, the scape sequences for the regular expressions may be different in other Editors or IDE's
        Example: \\w for alphanumberic characters, would be \w in IntelliJ
    */

    public static void main(String[] args) {
        testRegExForNpmPackages();
        testRegExForUrls();
    }


    /* 
        -------------------------------------------------------------------------------------------------------------------------
                    Methods for testing Regular Expressions to retrieve the Name, Version & Scope of Npm Packages
        -------------------------------------------------------------------------------------------------------------------------
    */
    private static void testRegExForNpmPackages() {
        Pattern patternForNpmPackages = Pattern.compile("(@*(?<scope>[^/]+)/)?(?<name>[^@]+)@(?!latest)(?<version>[^\\s]+)");

        // Npm packages that contain Scope
        String vueLoaderNpmPackage = "vue-loader-v16/vue-loader@16.2.0";
        String reactDomNpmPackage  = "@hot-loader/react-dom@17.0.1";

        // Npm packages that don't have scope
        String reactRedux    = "react-redux@7.2.4";
        String reactCalendar = "react-calendar@3.4.0";

        // Npm packages with invalid formats
        String invalidReactRedux          = "react-redux:7.2.4";
        String invalidVueLoaderNpmPackage = "vue-loader-v16-vue-loader@16.2.0";

        printHeaders("Testing RegEx to retrieve the name & version of Npm packages");

        // Gets the name & version for packages with scope
        System.out.println(findNameAndVersionOfNpmPackage(vueLoaderNpmPackage, patternForNpmPackages));
        System.out.println(findNameAndVersionOfNpmPackage(reactDomNpmPackage, patternForNpmPackages));

        // Gets the name & version for packages without scope
        System.out.println(findNameAndVersionOfNpmPackage(reactRedux, patternForNpmPackages));
        System.out.println(findNameAndVersionOfNpmPackage(reactCalendar, patternForNpmPackages));

        // Attempts to get the the name & version for invalid packages with scope
        System.out.println(findNameAndVersionOfNpmPackage(invalidReactRedux, patternForNpmPackages));
        System.out.println(findNameAndVersionOfNpmPackage(invalidVueLoaderNpmPackage, patternForNpmPackages));

        printHeaders("Testing RegEx to retrieve the scope of Npm packages");

        // Gets the scope for packages with scope
        System.out.println(findScopeOfNpmPackage(vueLoaderNpmPackage, patternForNpmPackages));
        System.out.println(findScopeOfNpmPackage(reactDomNpmPackage, patternForNpmPackages));

        // Attempts to get get the scope for package without scope, the scope will be null since the pattern matches 
        // but scope does not exist as a group
        System.out.println(findScopeOfNpmPackage(reactCalendar, patternForNpmPackages));

        // Attempts to get get the scope for invalid package, will print default message for packages that dont match the pattern
        System.out.println(findScopeOfNpmPackage(invalidReactRedux, patternForNpmPackages));
    }

    private static String findNameAndVersionOfNpmPackage(String npmPkg, Pattern patternForNpmPackages) {
        printHeaders(String.format("Getting Name & Version for this Npm packgage: %s", npmPkg));

        Matcher matcher = patternForNpmPackages.matcher(npmPkg);
        return matcher.find() ? String.format("package name: %-10s  |  package version: %s\n", matcher.group("name"), matcher.group("version")) : "NAME & VERSION NOT FOUND\n";
    }

    private static String findScopeOfNpmPackage(String npmPkg, Pattern patternForNpmPackages) {
        printHeaders(String.format("Getting Name & Version for this Npm packgage: %s", npmPkg));

        Matcher matcher = patternForNpmPackages.matcher(npmPkg);
        return matcher.find() ? String.format("package Scope: %s\n", matcher.group("scope")) : "SCOPE NOT FOUND\n";
    }


    /* 
        -------------------------------------------------------------------------------------------------------------------------
                    Methods for testing Regular Expressions to retrieve urls from a string
        -------------------------------------------------------------------------------------------------------------------------
    */

    private static void testRegExForUrls() {
        Pattern patternForStringsContainingUrls = Pattern.compile("\s*(?<url>ssh://git@.+\\.git|http://[^\s]+|https://[^\s]+|\\w+\\.com\s* |\\w+\\.net\s*|\\w+\\.gov\s*).*");

        // Strings with valid urls
        String gitErrorMsg = "npm ERR! enoent undefined ls-remote -h -t ssh://git@github.com/ajs/a.git";
        String urlWithHttp = "http://imMasteringRegularExperssions nothing fancy here";
        String urlWithHttps = "we got fancy & added https to our url https://imMasteringRegularExperssions";
        String urlWithDotCom = "imMasteringRegularExperssions.com sweet no need to type http";
        String urlWithDotNet = "and now we're no longer a commercial url imMasteringRegularExperssions.net";
        String urlWithDotGov = "The FBI was watching me practice & decided to buy my url so now it's imMasteringRegularExperssions.gov, so now their agents go there to practice regEx";

        // Strings with invalid urls        
        String invalidGitErrorMsg = "npm ERR! enoent undefined ls-remote -h -t ssh://github/ajs/a.git";
        String invalidUrlWithHttp = "http:/imMasteringRegularExperssions is missing a /";
        String invalidUrlWithHttps = "is missing the : here https//imMasteringRegularExperssions";
        String invalidUrlWithDotCom = "imMasteringRegularExperssions .com space between the .com";
        String invalidUrlWithDotNet = "missing period in this url imMasteringRegularExperssionsnet";
        String invalidUrlWithDotGov = "The FBI agents changed their url to this imMasteringRegularExperssions.go, and now everything is broken";

        printHeaders("Testing RegEx to retrieve valid common urls from strings");
        
        for (String stringWithValidUrl : Arrays.asList(gitErrorMsg, urlWithHttp, urlWithHttps, urlWithDotCom, urlWithDotNet, urlWithDotGov))
            System.out.printf("The Url is: %s\n\n", getUrlFromString(stringWithValidUrl, patternForStringsContainingUrls));

        printHeaders("Testing RegEx to attempt to retrieve invalid urls from strings");

        for (String stringWithValidUrl : Arrays.asList(invalidGitErrorMsg, invalidUrlWithHttp, invalidUrlWithHttps, invalidUrlWithDotCom, invalidUrlWithDotNet, invalidUrlWithDotGov))
            System.out.printf("The Url is: %s\n\n", getUrlFromString(stringWithValidUrl, patternForStringsContainingUrls));

    }

    private static String getUrlFromString(String stringWithUrl, Pattern patternForStringsContainingUrls) {
        printHeaders(String.format("Getting url from this string: %s", stringWithUrl));

        Matcher matcher = patternForStringsContainingUrls.matcher(stringWithUrl);
         return matcher.find() ? matcher.group("url") : "NO URL FOUND";
    }

    /* 
        -------------------------------------------------------------------------------------------------------------------------
                                        Header Methods
        -------------------------------------------------------------------------------------------------------------------------
    */

    private static void printHeaders(String headerMsg) {
        System.out.printf("%s\n|  %s  |\n%s\n\n", printHeaderBorders(headerMsg), headerMsg, printHeaderBorders(headerMsg));
    }

    private static String printHeaderBorders(String headerMsg) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < headerMsg.length() + 6; i++)
            stringBuilder.append("=");

        return stringBuilder.toString();
    }
}