package org.alfresco.repo;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class RestApiProcessor
{

    public List<RestApiDefinition> getApisInfo(List<String> apiPaths)
    {
        return null;
    }

    /**
     * Gets the full info for the provided file
     * @param file
     * @return
     * @throws Exception
     */
    private RestApiDefinition getApiInfo(File file) throws Exception
    {
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        String id = properties.getProperty("id");
        String order = properties.getProperty("order");
        
        RestApiDefinition info = new RestApiDefinition();
        info.setId(id);
        info.setOrder(Integer.parseInt(order));
        return info;
    }
}
