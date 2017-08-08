package xframe.springcloud.web;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }
    
    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String login(String userName, String password){
    	ServiceInstance instance = client.getLocalServiceInstance();
    	logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", userName:" + userName);
    	return "{\"code\":\"0000\", \"message\":\"success\"}";
    }
    
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String hello(String userName, String password) throws Exception{
    	ServiceInstance instance = client.getLocalServiceInstance();
    	//random sleep
    	int sleepTime = new java.util.Random().nextInt(3000);
    	logger.info("sleep time:"+sleepTime);
    	Thread.sleep(sleepTime);
    	logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", userName:" + userName);
    	return "{\"code\":\"0000\", \"message\":\"hello\"}";
    }
}
