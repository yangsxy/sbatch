package cn.yuan.odps;

import org.junit.Test;

import com.aliyun.odps.Instance;
import com.aliyun.odps.Odps;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.task.SQLTask;

public class OdpsTest {
	
	@Test
	public void testName() throws Exception {
		Account account = new AliyunAccount("","");
		Odps odps = new Odps(account);
		odps.setDefaultProject("");
		odps.setEndpoint("");
		Instance instance = SQLTask.run(odps, "");
	}

}
