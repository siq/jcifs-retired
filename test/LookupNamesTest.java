import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SID;
import org.testng.annotations.Test;

public class LookupNamesTest
{
    @Test
    public void testLookupNames1() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SID sid = SID.getFromName("datamaster.storediq.com", auth, "storediq\\testadmin");

        System.out.println(String.format("SID: %s", sid));
    }

    @Test
    public void testLookupNames2() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SID sid = SID.getFromName("datamaster.storediq.com", auth, "storediq\\aevans");

        System.out.println(String.format("SID: %s", sid));
    }
}
