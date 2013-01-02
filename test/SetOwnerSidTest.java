import jcifs.smb.*;
import org.testng.annotations.Test;

public class SetOwnerSidTest
{
    @Test
    public void getOwnerSidTest1() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SmbFile smbfile = new SmbFile("smb://172.17.18.5/aevans-a/untitled text 1.txt", auth);

        SecurityDescriptor sd = smbfile.getSecurityDescriptor(false);

        int readAccessRight = 0x00020000;
        SID sid = new SID("S-1-5-21-1547161642-115176313-682003330-4162");

        smbfile.revokePermission(sd, sid, readAccessRight);

    }

    @Test
    public void getOwnerSidTest2() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SmbFile smbfile = new SmbFile("smb://172.17.18.5/aevans-a/untitled text 1.txt", auth);

        SID owner = smbfile.getOwnerUser();
        SID group = smbfile.getOwnerGroup();

        System.out.println(String.format("Owner: %s", owner));
        System.out.println(String.format("Group: %s", group));

        for (ACE ace : smbfile.getSecurity())
        {
            System.out.println(String.format("ACE: %s", ace));
        }
    }
}
