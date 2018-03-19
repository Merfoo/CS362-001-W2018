
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase
{
    public UrlValidatorTest(String testName)
    {
        super(testName);
    }

    public void testManualTest()
    {
        //You can use this function to implement your manual testing
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("HTTP://www.google.com"));
    }

    public void testSchemePartition()
    {
        //Test URL scheme
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValidScheme("http"));
        assertTrue(urlVal.isValidScheme("https"));
        assertFalse(urlVal.isValidScheme("HTTP"));
        assertFalse(urlVal.isValidScheme("HTTPS"));
    }

    public void testAuthorityPartition()
    {
        //Test URL authority
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValidAuthority("www.google.com"));
        assertTrue(urlVal.isValidAuthority("go.com"));
        assertFalse(urlVal.isValidAuthority("256.256.256.256"));
        assertFalse(urlVal.isValidAuthority("1.2.3.4.5"));
    }

    public void testPathPartition()
    {
        //Test URL path
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValidPath("/"));
        assertTrue(urlVal.isValidPath("/abc123"));
        assertFalse(urlVal.isValidPath("/.."));
        assertFalse(urlVal.isValidPath("/../abc"));
    }

    public void testQueryPartition()
    {
        //Test URL query
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValidQuery("?"));
        assertTrue(urlVal.isValidQuery("?awesome=true"));
        assertFalse(urlVal.isValidQuery("? "));
        assertFalse(urlVal.isValidQuery(" "));
    }

    public void testFragmentPartition()
    {
        //Test URL fragment
        UrlValidator urlVal = new UrlValidator();
        assertTrue(urlVal.isValidFragment("fragment"));
        assertTrue(urlVal.isValidFragment(null));

        UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.NO_FRAGMENTS);
        assertTrue(urlVal2.isValidFragment(null));
        assertFalse(urlVal2.isValidFragment("fragment"));
    }

    //You need to create more test cases for your Partitions if you need to
    public void testIsValid()
    {
        //You can use this function for programming based testing
        // Array of valid urls
        String[] validUrls = new String[] {
            "www.google.com",
            "http://www.google.com"
        };

        // Array of invalid urls
        String[] invalidUrls = new String[] {
            "invalid url .com",
            ""
        };

        // Loop over valid/invalid urls and test for validity
        UrlValidator urlVal = new UrlValidator();

        for(int i = 0; i < validUrls.length; i++)
            assertTrue(urlVal.isValid(validUrls[i]));

        for(int i = 0; i < invalidUrls.length; i++)
            assertFalse(urlVal.isValid(invalidUrls[i]));
    }
}

