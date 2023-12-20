package com.httpstatuscodes.httpstatuscodesstudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "http_status_code")
public class HttpStatusCode {

//    CREATE TABLE http_status_codes (
//            id BIGINT PRIMARY KEY AUTO_INCREMENT,
//            code INT NOT NULL,
//            image_url VARCHAR(255)
//    );
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private int code;
    @Transient
    private String category; // 1xx, 2xx, 3xx, 4xx, 5xx
    @Transient
    private String categoryType; // informational, success, redirection, client error, server error
    @Transient
    private String meaning; // continue, ok, moved permanently, not found, internal server error
    @Transient
    private String description;
    @Column(name = "image_url")
    String imageUrl;

    public HttpStatusCode() {
    }

    public HttpStatusCode (int code, String imageUrl) {
        this.code = code;
        this.imageUrl = imageUrl;

        initialiseDerivedFields();
        initialiseStatusContextBasedOnCode();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "HttpStatusCode{" +
                "id=" + id +
                ", code=" + code +
                ", category='" + category + '\'' +
                ", categoryType='" + categoryType + '\'' +
                ", meaning='" + meaning + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    private void initialiseDerivedFields() {
        switch (code / 100) {
            case 1 -> {
                category = "1xx";
                categoryType = "Informational";
            }
            case 2 -> {
                category = "2xx";
                categoryType = "Success";
            }
            case 3 -> {
                category = "3xx";
                categoryType = "Redirection";
            }
            case 4 -> {
                category = "4xx";
                categoryType = "Client Error";
            }
            case 5 -> {
                category = "5xx";
                categoryType = "Server Error";
            }
            default -> {
                category = "Unknown";
                categoryType = "Unknown";
            }
        }
    }

    private void initialiseStatusContextBasedOnCode() {
        switch (code) {
            case 100 -> {
                meaning = "Continue";
                description = "The server has received the initial part of the request and expects the client to continue with the remainder.";
            }
            case 101 -> {
                meaning = "Switching Protocols";
                description = "The server is willing to change the application protocol being used on this connection.";
            }
            case 102 -> {
                meaning = "Processing";
                description = "The server has received and is processing the request, but no response is available yet.";
            }
            case 103 -> {
                meaning = "Early Hints";
                description = "Used to return some response headers before final HTTP message.";
            }
            case 200 -> {
                meaning = "OK";
                description = "The request has succeeded.";
            }
            case 201 -> {
                meaning = "Created";
                description = "The request has succeeded and a new resource has been created as a result.";
            }
            case 202 -> {
                meaning = "Accepted";
                description = "The request has been accepted for processing, but the processing has not been completed.";
            }
            case 203 -> {
                meaning = "Non-Authoritative Information";
                description = "The request has succeeded, but the returned meta-information is from a cached copy instead of the origin server.";
            }
            case 204 -> {
                meaning = "No Content";
                description = "The request has succeeded but returns no message body.";
            }
            case 205 -> {
                meaning = "Reset Content";
                description = "The request has succeeded but returns no message body.";
            }
            case 206 -> {
                meaning = "Partial Content";
                description = "The server is delivering only part of the resource due to a range header sent by the client.";
            }
            case 207 -> {
                meaning = "Multi-Status";
                description = "The message body that follows is by default an XML message and can contain a number of separate response codes, depending on how many sub-requests were made.";
            }
            case 208 -> {
                meaning = "Already Reported";
                description = "The members of a DAV binding have already been enumerated in a preceding part of the (multi-status) response, and are not being included again.";
            }
            case 226 -> {
                meaning = "IM Used";
                description = "The server returns a delta instead of the GET requested response it has been asked for.";
            }
            case 300 -> {
                meaning = "Multiple Choices";
                description = "The requested resource has multiple choices, each of which has a different location.";
            }
            case 301 -> {
                meaning = "Moved Permanently";
                description = "The URL of the requested resource has been changed permanently.";
            }
            case 302 -> {
                meaning = "Found";
                description = "The URL of the requested resource has been changed temporarily.";
            }
            case 303 -> {
                meaning = "See Other";
                description = "The response to the request can be found under another URL using a GET method.";
            }
            case 304 -> {
                meaning = "Not Modified";
                description = "The requested resource has not been modified since the date specified in the If-Modified-Since header.";
            }
            case 305 -> {
                meaning = "Use Proxy";
                description = "The requested resource must be accessed through the proxy given by the Location field.";
            }
            case 306 -> {
                meaning = "Switch Proxy";
                description = "The server response to a client HTTP request for a resource through a proxy when the proxy location has changed..";
            }
            case 307 -> {
                meaning = "Temporary Redirect";
                description = "The server sends this response to direct the client to get the requested resource at another URI with the same method that was used in the prior request.";
            }
            case 308 -> {
                meaning = "Permanent Redirect";
                description = "The server sends this response to direct the client to get the requested resource at another URI with the same method that was used in the prior request.";
            }
            case 400 -> {
                meaning = "Bad Request";
                description = "The server could not understand the request due to invalid syntax.";
            }
            case 401 -> {
                meaning = "Unauthorized";
                description = "Although the HTTP standard specifies \"unauthorized\", semantically this response means \"unauthenticated\".";
            }
            case 402 -> {
                meaning = "Payment Required";
                description = "Reserved for future use.";
            }
            case 403 -> {
                meaning = "Forbidden";
                description = "The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response.";
            }
            case 404 -> {
                meaning = "Not Found";
                description = "The server can not find requested resource.";
            }
            case 405 -> {
                meaning = "Method Not Allowed";
                description = "The request method is known by the server but has been disabled and cannot be used.";
            }
            case 406 -> {
                meaning = "Not Acceptable";
                description = "This response is sent when the web server, after performing server-driven content negotiation, doesn't find any content following the criteria given by the user agent.";
            }
            case 407 -> {
                meaning = "Proxy Authentication Required";
                description = "This is similar to 401 but authentication is needed to be done by a proxy.";
            }
            case 408 -> {
                meaning = "Request Timeout";
                description = "This response is sent on an idle connection by some servers, even without any previous request by the client.";
            }
            case 409 -> {
                meaning = "Conflict";
                description = "This response is sent when a request conflicts with the current state of the server.";
            }
            case 410 -> {
                meaning = "Gone";
                description = "This response is sent when the requested content has been permanently deleted from server, with no forwarding address.";
            }
            case 411 -> {
                meaning = "Length Required";
                description = "Server rejected the request because the Content-Length header field is not defined and the server requires it.";
            }
            case 412 -> {
                meaning = "Precondition Failed";
                description = "The client has indicated preconditions in its headers which the server does not meet.";
            }
            case 413 -> {
                meaning = "Payload Too Large";
                description = "Request entity is larger than limits defined by server; the server might close the connection or return an Retry-After header field.";
            }
            case 414 -> {
                meaning = "URI Too Long";
                description = "The URI requested by the client is longer than the server is willing to interpret.";
            }
            case 415 -> {
                meaning = "Unsupported Media Type";
                description = "The media format of the requested data is not supported by the server, so the server is rejecting the request.";
            }
            case 416 -> {
                meaning = "Range Not Satisfiable";
                description = "The range specified by the Range header field in the request can't be fulfilled; it's possible that the range is outside the size of the target URI's data.";
            }
            case 417 -> {
                meaning = "Expectation Failed";
                description = "This response code means the expectation indicated by the Expect request header field can't be met by the server.";
            }
            case 418 -> {
                meaning = "I'm a teapot";
                description = "The server refuses the attempt to brew coffee with a teapot.";
            }
            case 421 -> {
                meaning = "Misdirected Request";
                description = "The request was directed at a server that is not able to produce a response.";
            }
            case 422 -> {
                meaning = "Unprocessable Entity";
                description = "The request was well-formed but was unable to be followed due to semantic errors.";
            }
            case 423 -> {
                meaning = "Locked";
                description = "The resource that is being accessed is locked.";
            }
            case 424 -> {
                meaning = "Failed Dependency";
                description = "The request failed due to failure of a previous request.";
            }
            case 425 -> {
                meaning = "Too Early";
                description = "Indicates that the server is unwilling to risk processing a request that might be replayed.";
            }
            case 426 -> {
                meaning = "Upgrade Required";
                description = "The server refuses to perform the request using the current protocol but might be willing to do so after the client upgrades to a different protocol.";
            }
            case 428 -> {
                meaning = "Precondition Required";
                description = "The origin server requires the request to be conditional.";
            }
            case 429 -> {
                meaning = "Too Many Requests";
                description = "The user has sent too many requests in a given amount of time.";
            }
            case 431 -> {
                meaning = "Request Header Fields Too Large";
                description = "The server is unwilling to process the request because its header fields are too large.";
            }
            case 451 -> {
                meaning = "Unavailable For Legal Reasons";
                description = "The user-agent requested a resource that cannot legally be provided, such as a web page censored by a government.";
            }
            case 500 -> {
                meaning = "Internal Server Error";
                description = "The server has encountered a situation it doesn't know how to handle.";
            }
            case 501 -> {
                meaning = "Not Implemented";
                description = "The request method is not supported by the server and cannot be handled.";
            }
            case 502 -> {
                meaning = "Bad Gateway";
                description = "This error response means that the server, while working as a gateway to get a response needed to handle the request, got an invalid response.";
            }
            case 503 -> {
                meaning = "Service Unavailable";
                description = "The server is not ready to handle the request.";
            }
            case 504 -> {
                meaning = "Gateway Timeout";
                description = "This error response is given when the server is acting as a gateway and cannot get a response in time.";
            }
            case 505 -> {
                meaning = "HTTP Version Not Supported";
                description = "The HTTP version used in the request is not supported by the server.";
            }
            case 506 -> {
                meaning = "Variant Also Negotiates";
                description = "The server has an internal configuration error: transparent content negotiation for the request results in a circular reference.";
            }
            case 507 -> {
                meaning = "Insufficient Storage";
                description = "The server has an internal configuration error: the chosen variant resource is configured to engage in transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.";
            }
            case 508 -> {
                meaning = "Loop Detected";
                description = "The server detected an infinite loop while processing the request.";
            }
            case 510 -> {
                meaning = "Not Extended";
                description = "The request does not have a valid extension.";
            }
            case 511 -> {
                meaning = "Network Authentication Required";
                description = "The client needs to authenticate to gain network access.";
            }
            default -> meaning = "Unknown";
        }
    }
}
