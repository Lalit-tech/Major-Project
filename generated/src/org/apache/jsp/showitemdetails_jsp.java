package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import shoppingcatalog.dto.ItemDTO;

public final class showitemdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/stylesheet.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"script/jquery.js\">\n");
      out.write("            </script>\n");
      out.write("            <script type=\"text/javascript\" src=\"script/showItem.js\"></script>\n");
      out.write("        <title>Store Items</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

             String username=(String)session.getAttribute("username");
           
           
            if(username==null)
            {
                session.invalidate();
                response.sendRedirect("accessdenied.html");
            }
            else
            {
                StringBuffer displayBlock=new StringBuffer("<h1>My store-item Details</h1><p><em>You are viewing:</em><br/>");
               // System.out.println(displayBlock);
               
                ItemDTO details=(ItemDTO)request.getAttribute("itemdetails");
               
                    displayBlock.append("<strong><a href='StoreControllerServlet'>"+details.getItemType()+"&gt;</a>"+details.getItemName()+"</strong></p>");
                    displayBlock.append("<div style='float:left;'>");
                    displayBlock.append("<img src=\'images/"+details.getItemImage()+"'></div>");
                    displayBlock.append("<div style='float:left;padding-left:12px'>");
                    
                    displayBlock.append("<p><strong>Description:</strong><br/>"+details.getItemDesc()+"</p>");
                    displayBlock.append("<p><strong>Price:</strong>Rs"+details.getItemPrice()+"</p>");
                    displayBlock.append("<p><a href='addtocart.jsp?itemId="+details.getItemId()+"'>Add To Cart</a></p></div>");
                     displayBlock.append("<h4 id='logout'><a href='myorders.jsp'>My Orders</a>&nbsp;&nbsp;&nbsp;<a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                out.println(displayBlock);
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
