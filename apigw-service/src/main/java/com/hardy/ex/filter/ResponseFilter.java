package com.hardy.ex.filter;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / http://minkuk-jo.com
 * @since 2021. 01. 23.
 */
@Slf4j
@Component
public class ResponseFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final String CORRELATION_ID = "hd-correlation-id";

    private final Tracer tracer;

    public ResponseFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        context.getResponse().addHeader(CORRELATION_ID, tracer.currentSpan().context().traceIdString());
        log.info("## Response CorrelationId {}", tracer.currentSpan().context().traceIdString());
        return null;
    }

}
