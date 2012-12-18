import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SID;
import jcifs.smb.SmbFile;
import org.testng.annotations.Test;

public class GetOwnerSidTest
{
    @Test
    public void getOwnerSideTest1() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("storediq", "testadmin", "test123");
        SmbFile smbfile = new SmbFile("smb://datamaster.storediq.com/big12filetypes/docfiles/Months.doc", auth);

        SID owner = smbfile.getOwnerUser();
        SID group = smbfile.getOwnerGroup();

        System.out.println(String.format("Owner: %s", owner));
        System.out.println(String.format("Group: %s", group));
    }

    @Test
    public void getOwnerSideTest2() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "testuser1", "simplepw");
        SmbFile smbfile = new SmbFile("smb://windows2008.home/smbtest2/big12filetypes/docfiles/Months.doc", auth);

        SID owner = smbfile.getOwnerUser();
        SID group = smbfile.getOwnerGroup();

        System.out.println(String.format("Owner: %s", owner));
        System.out.println(String.format("Group: %s", group));
    }
}
