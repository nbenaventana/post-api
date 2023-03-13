package com.codeando.postapi.exceptions;


public class PostApiException extends RuntimeException {

   public PostApiException(final String message) {
      super(message);
   }

   public PostApiException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public PostApiException(final Throwable cause) {
      super(cause);
   }

}
