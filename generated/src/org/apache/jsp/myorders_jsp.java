package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shoppingcatalog.dao.StoreDAO;
import java.util.*;
import shoppingcatalog.dto.OrderDTO;
import java.text.*;

public final class myorders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/logo.html");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>My Orders Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"logo\">\r\n");
      out.write("         <img src=\"images/shopping_logo5.png\" >\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("       ");

           String username=(String)session.getAttribute("username");
           if(username==null)
            {
                response.sendRedirect("accessdenied.html");
            }
           else
           {
               StringBuffer displayBlock=new StringBuffer("<h1>My Store-My Orders</h1>");
               displayBlock.append("<div style='float:left;>");
               ArrayList<OrderDTO> orders=StoreDAO.getOrdersByCustomer(username);
               if(orders.size()==0)
               {
                   displayBlock.append("<p><strong>You have not placed any order yet</strong></p>");
                  
               }
               else
               {
                    displayBlock.append("<table border='1'>");
                        SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
                    displayBlock.append("<tr><th>Order Id</th><th>Order Amount</th><th>Order Date</th></tr>");
                   for(OrderDTO orderList:orders)
                   {
                       String datestr=sdf.format(orderList.getOrderDate());
                    displayBlock.append("<tr><td><a href='#' onclick=getdetails('"+orderList.getOrderId()+"')>"+orderList.getOrderId()+"</a></td><td>"+orderList.getOrderAmount()+"</td><td>"+datestr+"</td></tr>");
                       
                        
                   }
                   displayBlock.append("</table>");
                   
                       
                   
               }
               displayBlock.append("<p><a href='StoreControllerServlet'>Show Categories</a></p><div>");
                displayBlock.append("<h4 id='logout'><a href='LoginControllerServlet?logout=logout'>Logout</a></h4>");
                out.println(displayBlock);
               
           }
       
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
