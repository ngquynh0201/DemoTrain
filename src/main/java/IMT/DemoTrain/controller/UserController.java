package IMT.DemoTrain.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import IMT.DemoTrain.Utility.ExcelGeneratorUtility;
import IMT.DemoTrain.dto.request.ApiRespose;
import IMT.DemoTrain.dto.request.UserCreationRequest;
import IMT.DemoTrain.dto.request.UserUpdateRequest;
import IMT.DemoTrain.entity.User;
import IMT.DemoTrain.repository.EmployeeRepository;
import IMT.DemoTrain.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiRespose<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiRespose<User> apiRespose = new ApiRespose<>();

        apiRespose.setResult(userService.createUser(request));
        return apiRespose;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updatUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

     @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/excel")
    public void employeeDetailsReport(HttpServletResponse response) throws IOException {

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String fileType = "attachment; filename=employee_details_" + dateFormat.format(new Date()) + ".xls";
        response.setHeader("Content-Disposition", fileType);
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.getType());

        ExcelGeneratorUtility.employeeDetailReport(response, employeeRepository.findAll());
    }

}
