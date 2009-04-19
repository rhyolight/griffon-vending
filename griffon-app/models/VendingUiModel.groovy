import groovy.beans.Bindable
import javax.swing.ListModel

class VendingUiModel {
    @Bindable VendingMachine vendor
    @Bindable ListModel inventoryListModel
    @Bindable String status
    @Bindable String itemCode = ''
}