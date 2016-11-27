package sf.crom.client;

import java.io.IOException;

import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabSession;

public class GitLabClient {
public static void main(String args[]) throws IOException{
	//https://gitlab.com/contactdhawan/WsdlToJava.git
	GitlabAPI gitlabSession = GitlabAPI.connect("https://gitlab.com/contactdhawan/WsdlToJava.git", "Neeraj");
	System.out.println(gitlabSession.getCurrentSession().getEmail());
}
}
