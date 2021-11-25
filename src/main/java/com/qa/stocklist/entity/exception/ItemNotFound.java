package com.qa.stocklist.entity.exception;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Item does not exist with that ID")
public class ItemNotFound extends EntityNotFoundException {

}
