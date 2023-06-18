package com.webview

enum class ErrorType(val errorCode: Int) {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    NOT_ALLOWED(405),
    REQUEST_TIMEOUT(408),
    SYSTEM_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    OTHER(-1);
}