package com.daangnmarket.Models;

public class News
{
    private String totalResults;

    private Article[] articles;

    private String status;

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public Article[] getArticles ()
    {
        return articles;
    }

    public void setArticles (Article[] articles)
    {
        this.articles = articles;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [totalResults = "+totalResults+", articles = "+articles+", status = "+status+"]";
    }
}