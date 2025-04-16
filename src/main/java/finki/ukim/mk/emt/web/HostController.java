package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.domain.Host;
import finki.ukim.mk.emt.model.DisplayDto.HostDTO;
import finki.ukim.mk.emt.service.HostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    @Autowired
    private HostService hostService;

    @Operation(summary = "Get all hosts")
    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @Operation(summary = "Get host by ID")
    @GetMapping("/{id}")
    public ResponseEntity<HostDTO> getHostById(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHostById(id));
    }

    @Operation(summary = "Add new host")
    @PostMapping()
    public ResponseEntity<HostDTO> addHost(@RequestBody HostDTO dto) {
        hostService.addHost(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Update host by ID")
    @PutMapping("/{id}")
    public ResponseEntity<HostDTO> updateHost(@PathVariable Long id, @RequestBody HostDTO dto) {
        hostService.updateHost(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Delete host by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        hostService.deleteHost(id);
        return ResponseEntity.noContent().build();
    }
}

