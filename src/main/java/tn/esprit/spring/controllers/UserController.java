package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.MailService;
import tn.esprit.spring.services.UserService;

import javax.mail.MessagingException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class UserController {
    @Autowired
    private MailService notificationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TRAINER') or hasRole('PARTNER') or hasRole('WOMEN')")
    public String userAccess() {
        return "User Content.";
    }
        @GetMapping("/trainer")
    @PreAuthorize("hasRole('TRAINER')")
    public String trainerAccess() {
        return "Trainer Board.";
    }
    @GetMapping("/partner")
    @PreAuthorize("hasRole('PARTNER')")
    public String partnerAccess() {
        return "Partner Board.";
    }
    @GetMapping("/women")
    @PreAuthorize("hasRole('WOMEN')")
    public String WOMENAccess() {
        return "Women Board.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        List<User>users = userService.getAllUsers();
        return users;
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasRole('USER') or hasRole('TRAINER') or hasRole('PARTNER') or hasRole('WOMEN') or hasRole('ADMIN')")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable("id") int userId){
        userService.deleteUser((long) userId);
    }

    @PostMapping("/forgot-password")
    @PreAuthorize("hasRole('USER') or hasRole('TRAINER') or hasRole('PARTNER') or hasRole('WOMEN')")
    public String forgotPassword(@RequestParam String email) {

        String response = userService.forgotPassword(email);

        if (!response.startsWith("Invalid")) {
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }

    @PutMapping("/reset-password")
    @PreAuthorize("hasRole('USER') or hasRole('TRAINER') or hasRole('PARTNER') or hasRole('WOMEN')")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password) {

        return userService.resetPassword(token, password);
    }

    /**
     *
     * @return
     */
    @PostMapping("/send-mail")
    @PreAuthorize("hasRole('USER') or hasRole('TRAINER') or hasRole('PARTNER') or hasRole('WOMEN')")
    public String send(@RequestBody User user) {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmail("hazembensalem77@gmail.com");  //Receiver's email address
        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    /**
     *
     * @return
     * @throws MessagingException
     */
    @RequestMapping("send-mail-attachment")
    public String sendWithAttachment(@RequestBody User user) throws MessagingException {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmail("hazembensalem77@gmail.com"); //Receiver's email address

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    /*@GetMapping("/not-restricted")
    public String notRestricted() {
        return "you don't need to be logged in";
    }*/

    /*@GetMapping("/restricted")
    public String restricted() {
        return "if you see this you are logged in";
    }*/

    /*@PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }*/

    /*@GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(UserController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo();
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }*/

   /* @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }*/

}
