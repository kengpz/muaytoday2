package com.herokuapp.muaytoday.service.impl;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.muaytoday.service.RestTemplateService;

public class RestTemplateServiceImpl implements RestTemplateService {
	private static Logger logger = LoggerFactory.getLogger(RestTemplateServiceImpl.class);
	private ObjectMapper objectMapper;
	private RestTemplate restTemplate;
	private HttpHeaders httpHeaders;
	private HttpHeaders httpHtmlHeaders;
	private String url;

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		this.restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
	}

	public void setHttpHeaders(HttpHeaders httpHeaders) {
		MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
		this.httpHeaders = httpHeaders;
		this.httpHeaders.setContentType(mediaType);
	}

	public void setHttpHtmlHeaders(HttpHeaders httpHtmlHeaders) {
		MediaType mediaType = new MediaType("text", "html", Charset.forName("UTF-8"));
		this.httpHtmlHeaders = httpHtmlHeaders;
		this.httpHtmlHeaders.setContentType(mediaType);
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getForStringRequestUrl(String request) {
		return restTemplate.getForObject(request, String.class);
	}

	public String getForHtml(String action, Map params) {
		logger.info("GetForHtml : Action = " + url + action + ", Params = " + params);

		try {
			String json = objectMapper.writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHtmlHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);

			return responseEntity.getBody();
		} catch (Exception exception) {
			logger.info("GetForHtml : Action = " + url + action + ", Params = " + params + ", Exception = " + exception);
			return null;
		}
	}

	public String getForString(String action, String json) {
		logger.info("GetForString : Action = " + url + action + ", Json = " + json);

		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			String response = objectMapper.readValue(responseEntity.getBody(), String.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForString : Action = " + url + action + ", Json = " + json + ", Exception = " + exception);
			return null;
		}
	}

	public String getForString(String action, Map params) {
		logger.info("GetForString : Action = " + url + action + ", Params = " + params);

		try {
			String json = objectMapper.writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			String response = objectMapper.readValue(responseEntity.getBody(), String.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForString : Action = " + url + action + ", Params = " + params + ", Exception = " + exception);
			return null;
		}
	}

	public Number getForNumber(String action, String json) {
		logger.info("GetForNumber : Action = " + url + action + ", Json = " + json);

		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			Number response = objectMapper.readValue(responseEntity.getBody(), Number.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForNumber : Action = " + url + action + ", Json = " + json + ", Exception = " + exception);
			return null;
		}
	}

	public Number getForNumber(String action, Map params) {
		logger.info("GetForNumber : Action = " + url + action + ", Params = " + params);

		try {
			String json = objectMapper.writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			Number response = objectMapper.readValue(responseEntity.getBody(), Number.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForNumber : Action = " + url + action + ", Params = " + params + ", Exception = " + exception);
			return null;
		}
	}

	public Map getForMap(String action, String json) {
		logger.info("GetForMap : Action = " + action + ", Json = " + json);

		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			Map response = objectMapper.readValue(responseEntity.getBody(), Map.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForMap : Action = " + url + action + ", Json = " + json + ", Exception = " + exception);
			return null;
		}
	}

	public Map getForMap(String action, Map params) {
		logger.info("GetForMap : Action = " + action + ", Params = " + params);

		try {
			String json = objectMapper.writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			Map response = objectMapper.readValue(responseEntity.getBody(), Map.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForMap : Action = " + url + action + ", Params = " + params + ", Exception = " + exception);
			return null;
		}
	}

	public List getForList(String action, String json) {
		logger.info("GetForList : Action = " + action + ", Json = " + json);

		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			List response = objectMapper.readValue(responseEntity.getBody(), List.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForList : Action = " + url + action + ", Json = " + json + ", Exception = " + exception);
			return null;
		}
	}

	public List getForList(String action, Map params) {
		logger.info("GetForList : Action = " + action + ", Params = " + params);

		try {
			String json = objectMapper.writeValueAsString(params);
			HttpEntity<String> requestEntity = new HttpEntity<String>(json, httpHeaders);
			ResponseEntity<String> responseEntity = restTemplate.exchange(url + action, HttpMethod.POST, requestEntity, String.class);
			List response = objectMapper.readValue(responseEntity.getBody(), List.class);

			return response;
		} catch (Exception exception) {
			logger.info("GetForList : Action = " + url + action + ", Params = " + params + ", Exception = " + exception);
			return null;
		}
	}
}