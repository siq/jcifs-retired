import jcifs.smb.*;
import org.testng.annotations.Test;

public class SetOwnerSidTest
{
    @Test
    public void getOwnerSidTest1() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SmbFile smbfile = new SmbFile("smb://172.17.18.5/aevans-a/test4.txt", auth);

//        SID sid = new SID("S-1-5-21-1870922669-3917736479-4101635975-1001");
        SID sid = SID.getFromName("172.17.18.5", auth, "storediq\\aevans");

        System.out.println("update owner: " + smbfile.updateOwner(sid));
    }

    @Test
    public void getOwnerSidTest2() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SmbFile smbfile = new SmbFile("smb://172.17.18.5/aevans-a/test4.txt", auth);

        SID owner = smbfile.getOwnerUser();
        SID group = smbfile.getOwnerGroup();

        owner.resolve("siq-dc3.storediq.com", auth);

        System.out.println(String.format("Owner: %s", owner));
        System.out.println(String.format("Group: %s", group));

        for (ACE ace : smbfile.getSecurity())
        {
            System.out.println(String.format("ACE: %s", ace));
        }
    }
}
