package org.alfresco.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class IdExtracterTest
{

    @Test
    public void testIdExtracter() throws Exception
    {
        String path = ".\\src\\main\\webapp\\definitions\\alfresco-core.yaml";
        File file = new File(path);
        System.out.println(extractId(file));
    }

    /**
     * Extract the api id from a yaml file containing the line apiId:%API_ID%
     * @param file the yaml file
     * @return the api id or null if no id provided of file could not be read
     */
    private String extractId(File file)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            try
            {
                Pattern pattern = Pattern.compile("(apiId:)(.*)$");
                while ((line = br.readLine()) != null)
                {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find())
                    {
                        return matcher.group(2);
                    }
                }
            } 
            finally
            {
                br.close();
            }
        } 
        catch (IOException ex)
        {
            return null;
        }

        return null;
    }
}
