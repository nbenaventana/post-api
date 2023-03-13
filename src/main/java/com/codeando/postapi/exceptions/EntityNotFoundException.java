package com.codeando.postapi.exceptions;

public class EntityNotFoundException extends PostApiException {

   public EntityNotFoundException(final String message) {
      super(message);
   }

   public EntityNotFoundException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public EntityNotFoundException(final Throwable cause) {
      super(cause);
   }

}
