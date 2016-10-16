package sf.crom.calling;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import redis.clients.jedis.Jedis;



public class MyClass {
	Jedis jedis;
	MyClass(){
		init();
	}
	
	public void init(){
		//"52.43.245.145" 
		jedis = new Jedis("redis",6379);
	}
	@GET
	@Path("/get/{key}")
	public String getValue(@PathParam("key")String key){	
		
		return jedis.get(key);
	}
	
	@POST
	@Path("/set")
	public void add(@FormParam("key") String key,@FormParam("value") String value){
		System.out.println(key+"\t"+value);
	      System.out.println("Connection to server sucessfully");
	      System.out.println("Server is running: "+jedis.ping());
	      jedis.set(key, value);
	}
}
