package org.bsoftware.ward.controllers.api;

import org.bsoftware.ward.components.wrappers.RestResponseEntityWrapper;
import org.bsoftware.ward.dto.implementation.SetupDto;
import org.bsoftware.ward.services.implementation.SetupService;
import org.bsoftware.ward.validators.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * SettingsController displays responses from rest API
 *
 * @author Rudolf Barbu
 * @version 1.0.1
 */
@RestController
@RequestMapping(value = "/api/settings")
@SuppressWarnings(value = {"unused", "FieldMayBeFinal"})
public class SetupController
{
    /**
     * Autowired SetupService object
     * Used for posting settings information in database
     */
    private SetupService setupService;

    /**
     * Autowired RestResponseEntityWrapper object
     * Used as response wrapper bean, which provides Json headers automatically
     */
    private RestResponseEntityWrapper restResponseEntityWrapper;

    /**
     * Posting settings into database
     *
     * @param setupDto dto with data
     * @return OR response with empty body
     */
    @PostMapping
    public ResponseEntity<?> postSettings(@Validated(value = {RequestValidator.PostRequest.class}) @RequestBody SetupDto setupDto) throws Exception
    {
        return restResponseEntityWrapper.wrap(setupService.post(setupDto));
    }

    /**
     * Used for autowiring necessary objects
     *
     * @param setupService autowired SettingsService object
     * @param restResponseEntityWrapper autowired RestResponseEntityWrapper object
     */
    @Autowired
    public SetupController(SetupService setupService, RestResponseEntityWrapper restResponseEntityWrapper)
    {
        this.setupService = setupService;
        this.restResponseEntityWrapper = restResponseEntityWrapper;
    }
}