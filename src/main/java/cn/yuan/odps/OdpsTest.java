package cn.yuan.odps;

import java.util.List;

import org.junit.Test;

import com.aliyun.odps.Instance;
import com.aliyun.odps.Odps;
import com.aliyun.odps.account.Account;
import com.aliyun.odps.account.AliyunAccount;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.task.SQLTask;

public class OdpsTest {
	
	@Test
	public void testName() throws Exception {
		Account account = new AliyunAccount("SxagsMTJqHdl0vvX","symUVH5e3uq8Ef0xQJePiBKQWiIzAs");
		Odps odps = new Odps(account);
		odps.setDefaultProject("odps_loyalty_dev");
		odps.setEndpoint("http://service.odps.aliyun.com/api");
		Instance instance = SQLTask.run(odps, "show grants;");
		instance.waitForSuccess();
		List<Record> result = SQLTask.getResult(instance);
		for (Record record : result) {
			String string = record.get(0).toString();
			System.out.println(string);
		}
	}

}
