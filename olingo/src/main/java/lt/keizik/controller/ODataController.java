package lt.keizik.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.olingo.commons.api.ex.ODataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataRequestHandler;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;

@RestController
@RequestMapping("Trippin/v1/")
@RequestScope
public class ODataController {
  
  private JPAODataSessionContextAccess serviceContext;
  private JPAODataRequestContext requestContext;

  public ODataController(@Autowired JPAODataSessionContextAccess serviceContext,
      @Autowired JPAODataRequestContext requestContext) {
    super();
    this.serviceContext = serviceContext;
    this.requestContext = requestContext;
  }
  
  @RequestMapping(value = "**", method = { RequestMethod.GET, RequestMethod.PATCH, // NOSONAR
      RequestMethod.POST, RequestMethod.DELETE })
  public void crud(final HttpServletRequest req, final HttpServletResponse resp) throws ODataException {

    new JPAODataRequestHandler(serviceContext, requestContext).process(req, resp);
  }
}
