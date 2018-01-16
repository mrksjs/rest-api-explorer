package org.alfresco.repo;

/**
 * POJO object keeping information about a rest api
 */
public class RestApiDefinition
{
    private String id;
    private int order;
    private String yamlUrl;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

    public String getYamlUrl()
    {
        return yamlUrl;
    }

    public void setYamlUrl(String yamlUrl)
    {
        this.yamlUrl = yamlUrl;
    }
}
