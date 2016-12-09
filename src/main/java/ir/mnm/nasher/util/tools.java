package ir.mnm.nasher.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mghasemy on 12/9/16.
 */
public class tools {
    public List<String> tag(String in){
        if(in==null){
            return null;
        }
        List<String> res=new ArrayList<String>();
        String l[]=in.split("[,،]");
        for(String i:l){
            res.add(i);
        }
        return res;
    }
}
