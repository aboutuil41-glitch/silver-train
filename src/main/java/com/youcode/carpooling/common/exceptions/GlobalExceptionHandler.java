package com.youcode.carpooling.common.exceptions;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return build(HttpStatus.NOT_FOUND, "not-found", ex.getMessage(), request);
    }

    @ExceptionHandler(ForbiddenActionException.class)
    public ProblemDetail handleForbidden(ForbiddenActionException ex, HttpServletRequest request) {
        return build(HttpStatus.FORBIDDEN, "forbidden", ex.getMessage(), request);
    }

    private ProblemDetail build(HttpStatus status, String type, String message, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, message);
        problem.setType(URI.create("/errors/" + type));
        problem.setProperty("timestamp", Instant.now());
        problem.setProperty("path", request.getRequestURI());
        return problem;
    }
}
