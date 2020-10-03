package mashup.backend.tich.item.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mashup.backend.tich.item.dto.ItemResponseDto;
import mashup.backend.tich.item.dto.ItemSaveRequestDto;
import mashup.backend.tich.item.dto.ItemUpdateRequestDto;
import mashup.backend.tich.item.service.ItemService;
<<<<<<< HEAD
import mashup.backend.tich.jwt.JwtProvider;
import mashup.backend.tich.user.domain.Role;
import mashup.backend.tich.user.domain.User;
import mashup.backend.tich.user.domain.UserRepository;
=======
import mashup.backend.tich.user.domain.User;
>>>>>>> f0aec81a1e80ee18a8dbb230d1e805623e3e0361
import mashup.backend.tich.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
<<<<<<< HEAD
    private final UserRepository userRepository;
=======
>>>>>>> f0aec81a1e80ee18a8dbb230d1e805623e3e0361
    private final UserService userService;

    @ApiOperation("생활용품 목록 조회")
    @GetMapping
<<<<<<< HEAD
    public ResponseEntity<List<ItemResponseDto>> findItems(@RequestHeader("TICH-TOKEN") String accessToken) {
        User user = userService.findUserByToken(accessToken);
=======
    public ResponseEntity<List<ItemResponseDto>> findItems(@RequestHeader("TICH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
>>>>>>> f0aec81a1e80ee18a8dbb230d1e805623e3e0361

        List<ItemResponseDto> itemsResponseDto = itemService.findItems(user);

        return ResponseEntity.status(HttpStatus.OK).body(itemsResponseDto);
    }

    @ApiOperation("생활용품 상세 조회")
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponseDto> findItem(@RequestHeader("TICH-TOKEN") String token,
                                                    @PathVariable Long itemId) {
        User user = userService.findUserByToken(token);

        ItemResponseDto itemResponseDto = itemService.findItem(user, itemId);

        return ResponseEntity.status(HttpStatus.OK).body(itemResponseDto);
    }

    @ApiOperation("생활용품 등록")
    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<ItemResponseDto> saveItem(@RequestHeader("TICH-TOKEN") String accessToken,
                                                    @RequestBody ItemSaveRequestDto requestDto) {
        User user = userService.findUserByToken(accessToken);
=======
    public ResponseEntity<ItemResponseDto> saveItem(@RequestHeader("TICH-TOKEN") String token,
                                                    @RequestBody ItemSaveRequestDto requestDto) {
        User user = userService.findUserByToken(token);
>>>>>>> f0aec81a1e80ee18a8dbb230d1e805623e3e0361

        ItemResponseDto itemResponseDto = itemService.saveItem(requestDto, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponseDto);
    }

    @ApiOperation("생활용품 수정")
    @PutMapping
    public ResponseEntity<ItemResponseDto> updateItem(@RequestHeader("TICH-TOKEN") String token,
                                                      @RequestBody ItemUpdateRequestDto requestDto) {
        User user = userService.findUserByToken(token);

        ItemResponseDto itemResponseDto = itemService.updateItem(requestDto, user);

        return ResponseEntity.status(HttpStatus.OK).body(itemResponseDto);
    }

    @ApiOperation("생활용품 삭제")
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@RequestHeader("TICH-TOKEN") String token,
                                           @PathVariable Long itemId) {
        User user = userService.findUserByToken(token);

        itemService.deleteItem(user, itemId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
