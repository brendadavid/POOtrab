import trem.CarroFerroviario;
import trem.Locomotiva;
import trem.Vagao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Patio {

    private final List<CarroFerroviario> carrosFerroviarios;

    public Patio(List<CarroFerroviario> carrosFerroviarios) {
        this.carrosFerroviarios = carrosFerroviarios;
    }

    public Patio(String path) {
        this.carrosFerroviarios = carregaDadosCarros(path);
    }

    private List<CarroFerroviario> carregaDadosCarros(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile()))) {
            return lines.map(this::parseCarro).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao carregar arquivo de carros ferroviarios!");
        }
    }

    private CarroFerroviario parseCarro(String line) {
        String[] values = line.split(";");
        switch (values[0]) {
            case "vagao":
                return new Vagao(
                    Integer.parseInt(values[1]),
                    Double.parseDouble(values[2])
                );
            case "locomotiva":
                return new Locomotiva(
                    Integer.parseInt(values[1]),
                    Double.parseDouble(values[2]),
                    Integer.parseInt(values[3])
                );
            default: return null;
        }
    }

    public List<CarroFerroviario> getCarrosFerroviarios() {
        return carrosFerroviarios;
    }

    @Override
    public String toString() {
        return String.format("Patio{carrosFerroviarios=\n%s\n}", carrosFerroviarios);
    }
}
