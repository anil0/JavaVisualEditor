/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uk.anil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author anil
 */
public class JsonClassParser 
{
    public static void parseJsonClass( final String json )
    {
        System.out.println(json);
        try
        {
            System.out.println( json );        
            final Object tempJsonObject = new JSONTokener( json ).nextValue();
            
            if( tempJsonObject instanceof JSONArray )
            {
                final JSONArray jsonArray = new JSONArray( json );
                for( int i = 0; i < jsonArray.length(); i++ )
                {
                    final JSONObject jsonObject = jsonArray.getJSONObject( i );
                    
                }
            }
            
            if( tempJsonObject instanceof JSONObject )
            {
                final JSONObject jsonObject = new JSONObject( json );
                classToBeCreated(jsonObject);
            }
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
    }
    
    private static Clazz classToBeCreated( final JSONObject jsonObj )
    {
        List<?> foo = new ArrayList<>();
        System.out.println(jsonObj);
        Object data = jsonObj.get("data");
        JSONArray children = jsonObj.getJSONArray("children");

        System.out.println("data: " + data);
        System.out.println("Children: " + children);

        test(children,jsonObj);
        
        return new Clazz( "", foo );            
    }

    private static void test(JSONArray children,JSONObject jsonObj)
    {
        
        for (int i = 0; i < children.length(); i++) 
        {
            JSONObject child = children.getJSONObject(i);
            System.out.println("i = " + i +"\t"+ child);
            
            test(child.getJSONArray("children"),jsonObj);

        }
    }
    private static void parseJSON(JSONObject json) 
    {
        //System.out.println(json);
        //System.out.println(json.get("data"));
        //System.out.println(jsonObj.get("children"));
        
        JSONArray children = json.getJSONArray("children");
        
        if(children.length() > 0)
        {
            for(int i = 0; i < children.length(); i++)
            {
                JSONObject jsonObj = children.getJSONObject(i);
                
                System.out.println("json data: " + jsonObj.get("data"));
                System.out.println("json children: " + jsonObj.get("children"));
                
                parseJSON(jsonObj);

            }
        }
    }
    
    static class Children
    {
        private String data;
        private String children;

        public Children(String data, String children) {
            this.data = data;
            this.children = children;
        }

        public String getData() {
            return data;
        }

        public String getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "Children{" + "data=" + data + ", children=" + children + '}';
        }
        
        
    }
    
    static class Clazz
    {                    
        private String data;
        private List<?> children;

        public Clazz(String data, List<?> children) {
            this.data = data;
            this.children = children;
        }

        @Override
        public String toString() {
            return "Clazz{" + "data=" + data + ", children=" + children + '}';
        }
    }       
}
