package br.com.digitalinnovation.abruzzo.project_cities_api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class ErrorController extends BasicErrorController {

    Logger log = LoggerFactory.getLogger("Error Interceptor");

    public ErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
        super(errorAttributes, serverProperties.getError());
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest httpServletRequest) {
            HttpStatus status = this.getStatus(httpServletRequest);
            if (status == HttpStatus.NO_CONTENT) {
                return new ResponseEntity(status);
            } else {
                Map<String, Object> body = this.getErrorAttributes(httpServletRequest, this.getErrorAttributeOptions(httpServletRequest, MediaType.ALL));
                body.forEach( (key,value) -> log.info("Error attribute: Key: {} - Value: {}",key,value) );
                return new ResponseEntity(body, status);
            }
    }
}
