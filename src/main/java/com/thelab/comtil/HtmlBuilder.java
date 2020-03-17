/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

import java.util.ArrayList;

/**
 *
 * @author pohan
 */
public class HtmlBuilder {
    StringBuilder header = new StringBuilder();
    //StringBuilder body = new StringBuilder(); 
    ArrayList<String> cssFiles = new ArrayList<>();
    ArrayList<HtmlElement> elements = new ArrayList<>();
    ArrayList<HtmlElement> titles = new ArrayList<>();
    ArrayList<HtmlLink> menus = new ArrayList<>();
    ArrayList<HtmlScript> scripts = new ArrayList<>();
    ArrayList<ScriptTag> scriptTags = new ArrayList<>();
    ArrayList<HtmlGoogleFont> googlefonts = new ArrayList<>();
    ArrayList<HtmlPageSegment> segments = new ArrayList<>();
    String pageTitle = null;
    
    HtmlThemeCustom theme = new HtmlThemeDefault();
    HtmlLink backLink = null;
    
    String title = null;

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void addCssFile(String cssFileName){
        cssFiles.add(cssFileName);
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
    
    public void addElements(HtmlElement element){
        elements.add(element);
    }
    
    public void addMenu(String caption, String link){
        menus.add(new HtmlLink(caption, link));
    }
    
    public void setBackLink(String link){
        backLink = new HtmlLink("Back", link == null ? "/" : link){
            @Override
            public String getClassname() {
                return "back";
            }
        };
    }
    
    public void addSegment(HtmlPageSegment seg){
        segments.add(seg);
    }

    @Override
    public String toString() {
        StringBuilder sbut = new StringBuilder();
        sbut.append("<html>");
        sbut.append("<header>");
        if (title != null){
            sbut.append("<title>" + title + "</title>");
        }
        sbut.append(header);

        for (HtmlGoogleFont gf : googlefonts){
            sbut.append(gf.generate());
        }
        
        for (String f : cssFiles) {
            sbut.append(String.format("<link rel='stylesheet' href='/%s' type='text/css'>", f));
        }
        
            
        sbut.append("</header>");
        sbut.append("<body>");
        
        if (pageTitle != null){
            sbut.append(String.format("<h1>%s</h1>", pageTitle));
        }
        
        if (menus.size() > 0){
            sbut.append(theme.generateSideMenu(menus));
        }
        
        sbut.append("<div>");
        
        if (backLink != null){
            sbut.append(backLink.generate());
        }
        
        for (HtmlElement he : titles){
            sbut.append(he.generate());
        }
        
        for (HtmlElement he : elements){
            sbut.append(he.generate());
        }
        
        sbut.append("</div>");
        
        for (HtmlPageSegment ps : segments){
            sbut.append(ps.generate());
        }
                
        sbut.append("</body>");
        if (scripts.size() > 0){
            sbut.append("<script>");
            for (HtmlScript hs : scripts){
                String s = hs.generate();
                if (scriptTags.size() > 0){
                    for (ScriptTag tag : scriptTags){
                        s = s.replace(tag.getTag(), tag.getValue());
                    }
                }
                sbut.append(s);
            }
            sbut.append("</script>");
        }
        sbut.append("</html>");
        return sbut.toString();
    }
    
    public void addDiv(String id){
        elements.add(new HtmlDiv(id));
    }
    
    public void addScript(String scriptFileName){
        scripts.add(new HtmlScript(scriptFileName));
    }
    
    public void addScriptTag(String tag, String value){
        scriptTags.add(new ScriptTag(tag, value));
    }
    
    public void addGoogleFont(String fontName){
        googlefonts.add(new HtmlGoogleFont(fontName));
    }
    
}
