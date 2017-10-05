package by.home.hryhoryeu.coffee.dto;

import java.util.List;

public class SelectedItemsDTO {

    private List<Long> selectedTypes;
    private List<String> quantitySelectedItems;

    public SelectedItemsDTO() {}

    public SelectedItemsDTO(List<Long> selectedTypes, List<String> quantitySelectedItems) {
        this.selectedTypes = selectedTypes;
        this.quantitySelectedItems = quantitySelectedItems;
    }

    public List<Long> getSelectedTypes() {
        return selectedTypes;
    }

    public void setSelectedTypes(List<Long> selectedTypes) {
        this.selectedTypes = selectedTypes;
    }

    public List<String> getQuantitySelectedItems() {
        return quantitySelectedItems;
    }

    public void setQuantitySelectedItems(List<String> quantitySelectedItems) {
        this.quantitySelectedItems = quantitySelectedItems;
    }
}
