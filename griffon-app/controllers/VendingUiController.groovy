import javax.swing.DefaultListModel

class VendingUiController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        def bank = new File('../griffon-app/resources/bank.txt').text
        def inventory = new File('../griffon-app/resources/inventory.txt').text
        def vendor = new VendingMachine()
        vendor.serviceMode = true
        def loader = new InventoryLoader(vendor)
        loader.loadBank(bank)
        loader.load(inventory)
        vendor.serviceMode = false
        model.vendor = vendor
        model.inventoryListModel = new DefaultListModel()
        inventory.eachLine {
            model.inventoryListModel.addElement(it)
        }
    }
    
    def pay = { evt = null ->
        def cmd = evt.actionCommand.toLowerCase()
        model.status = 'Deposited: ' + model.vendor."${cmd}"()
    }
    
    def vend = { evt = null ->
        def vendResult = model.vendor.vend(model.itemCode)
        model.status = vendResult
    }
    
    def coinReturn = { evt = null ->
        println model.status
        model.status = model.vendor.coinReturn()
    }
}