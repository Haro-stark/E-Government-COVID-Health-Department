package com.example.EGovt_CovidHealthApp.Controller;

import com.example.EGovt_CovidHealthApp.Model.Entity.Permission;
import com.example.EGovt_CovidHealthApp.Service.PermissionService;
import com.example.EGovt_CovidHealthApp.Util.AuthorizationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * The type Permission controller.
 *
 * @author Haroon Rasheed
 * @version 1.6
 * @description This class is Controller class which just takes the data from frontend and give data to frontend. Authorization is check in this class. Also This class contains servlets path. It contains api list all privilege, find privilege and delete privilege.
 * @createdTime 12 October 2021
 */
@EnableSwagger2
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger LOG = LogManager.getLogger(PermissionController.class);
    //an ID that is used to authenticate the request header authentication token
    private final static String uuid = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454";
    private final PermissionService permissionService;

    /**
     * Instantiates a new Permission controller. Initialized the constructor instead of  annotation.
     *
     * @param permissionService the permission service
     */
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    /**
     * Gets all permissions.
     *
     * @param authToken the auth token
     * @return the all permissions
     * @throws Exception the exception
     */
    @GetMapping("")
    public ResponseEntity<List<Permission>> getAllPermissions(@RequestHeader("Authorization") String authToken) throws Exception {

        AuthorizationUtil.authorized(authToken);
        return permissionService.getAllPermissions();
    }

    /**
     * Create permission response entity.
     *
     * @param authToken   the auth token
     * @param permissions the permissions
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/addPermission")
    public ResponseEntity<List<Permission>> createPermission(@RequestHeader("Authorization") String authToken,
                                                             @Validated @RequestBody List<Permission> permissions) throws Exception {

        AuthorizationUtil.authorized(authToken);
        return permissionService.addPermission(permissions);
    }

    /**
     * Delete permission from the database.
     *
     * @param authToken the auth token
     * @param id        the id
     * @return the response entity
     * @throws Exception the exception
     */
    @DeleteMapping("/deletePermission/{id}")
    public ResponseEntity<Object> deletePermission(@RequestHeader("Authorization") String authToken,
                                                   @PathVariable Long id) throws Exception {

        AuthorizationUtil.authorized(authToken);
        return permissionService.deletePermission(id);
    }

    /**
     * Updates permission from database.
     *
     * @param authToken  the auth token
     * @param permission the permission
     * @return the response entity
     * @throws Exception the exception
     */
    @PostMapping("/updatePermission")
    public ResponseEntity<Permission> updatePermission(@RequestHeader("Authorization") String authToken,
                                                       @Validated @RequestBody Permission permission) throws Exception {

        AuthorizationUtil.authorized(authToken);
        return permissionService.updatePermission(permission);
    }

}

