import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import org.testng.annotations.Test;

public class GetAccessedTimeTest
{
    @Test
    public void getAccessedTimeTest() throws Exception
    {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, "testuser1", "simplepw");
        SmbFile smbfile = new SmbFile("smb://windows2008.home/smbtest2/big12filetypes/docfiles/Months.doc", auth);

        System.out.println(String.format("File exists: %s", smbfile.exists()));
        System.out.println(String.format("Accessed time: %s", smbfile.getLastAccessed()));
        System.out.println(String.format("Modified time: %s", smbfile.getDate()));
    }
}
