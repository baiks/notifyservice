package com.notify.service.impl;

import com.notify.service.services.HttpCallsService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Service
public class HttpCallsServiceImpl implements HttpCallsService {
    @Override
    public HttpResponse post(String request, String url) {
        try {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(5 * 1000)
                    .setConnectionRequestTimeout(5 * 1000)
                    .setSocketTimeout(5 * 1000).build(); //Could do better on parametizing these if had sufficient time
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            HttpUriRequest httpUriRequest = RequestBuilder.post(uri).setEntity(new StringEntity(request))
                    .setHeader("Content-type", "application/json").build();
            HttpClient httpclient = null;
            if (url.startsWith("https")) {
                SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                        .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true).build();
                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                        NoopHostnameVerifier.INSTANCE);
                httpclient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory)
                        .setDefaultRequestConfig(config).build();
            } else {
                httpclient = HttpClients.custom().setDefaultRequestConfig(config).build();
            }
            return httpclient.execute(httpUriRequest);
//            HttpEntity entity = response.getEntity();
//            return EntityUtils.toString(entity);
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException | KeyStoreException |
                 IOException ex) {
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public HttpResponse patch(String request, String url) {
        try {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(5 * 1000)
                    .setConnectionRequestTimeout(5 * 1000)
                    .setSocketTimeout(5 * 1000).build(); //Could do better on parametizing these if had sufficient time
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            HttpUriRequest httpUriRequest = RequestBuilder.patch(uri).setEntity(new StringEntity(request))
                    .setHeader("Content-type", "application/json").build();
            HttpClient httpclient = null;
            if (url.startsWith("https")) {
                SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                        .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true).build();
                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                        NoopHostnameVerifier.INSTANCE);
                httpclient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory)
                        .setDefaultRequestConfig(config).build();
            } else {
                httpclient = HttpClients.custom().setDefaultRequestConfig(config).build();
            }
            return httpclient.execute(httpUriRequest);
//            HttpEntity entity = response.getEntity();
//            return EntityUtils.toString(entity);
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException | KeyStoreException |
                 IOException ex) {
            ex.printStackTrace();

        }
        return null;
    }

    @Override
    public HttpResponse get(String url) {
        try {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(5 * 1000)
                    .setConnectionRequestTimeout(5 * 1000)
                    .setSocketTimeout(5 * 1000).build(); //Could do better on parametizing these if had sufficient time
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            HttpUriRequest httpUriRequest = RequestBuilder.get(uri)
                    .setHeader("Content-type", "application/json").build();
            HttpClient httpclient = null;
            if (url.startsWith("https")) {
                SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                        .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true).build();
                SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                        NoopHostnameVerifier.INSTANCE);
                httpclient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory)
                        .setDefaultRequestConfig(config).build();
            } else {
                httpclient = HttpClients.custom().setDefaultRequestConfig(config).build();
            }
            return httpclient.execute(httpUriRequest);
//            HttpEntity entity = response.getEntity();
//            return EntityUtils.toString(entity);
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException | KeyStoreException |
                 IOException ex) {
            ex.printStackTrace();

        }
        return null;
    }
}
