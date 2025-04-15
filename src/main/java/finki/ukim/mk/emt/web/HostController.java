package finki.ukim.mk.emt.web;

import finki.ukim.mk.emt.model.domain.Host;
import finki.ukim.mk.emt.model.CreateDto.HostDTO;
import finki.ukim.mk.emt.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
public class HostController {
    @Autowired
    private HostService hostService;

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HostDTO> getHostById(@PathVariable Long id) {
        return ResponseEntity.ok(hostService.getHostById(id));
    }

    @PostMapping()
    public ResponseEntity<HostDTO> addHost(@RequestBody HostDTO dto) {
        hostService.addHost(dto);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HostDTO> updateHost(@PathVariable Long id, @RequestBody HostDTO dto) {
        hostService.updateHost(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHost(@PathVariable Long id) {
        hostService.deleteHost(id);
        return ResponseEntity.noContent().build();
    }
}

