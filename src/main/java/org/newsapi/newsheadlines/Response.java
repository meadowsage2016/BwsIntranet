package org.newsapi.newsheadlines;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("sortBy")
	private String sortBy;

	@JsonProperty("source")
	private String source;

	@JsonProperty("articles")
	private List<ArticlesItem> articles;

	@JsonProperty("status")
	private String status;

	public void setSortBy(String sortBy){
		this.sortBy = sortBy;
	}

	public String getSortBy(){
		return sortBy;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setArticles(List<ArticlesItem> articles){
		this.articles = articles;
	}

	public List<ArticlesItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"sortBy = '" + sortBy + '\'' + 
			",source = '" + source + '\'' + 
			",articles = '" + articles + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}