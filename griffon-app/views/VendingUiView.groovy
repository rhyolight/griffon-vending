vendingFrame = application(title:'vending-ui', location:[50,50], pack:true, locationByPlatform:true) {
    borderLayout()
    vbox(constraints:WEST) {
        button('Nickel', id:'nickel', actionPerformed: controller.pay)
        button('Dime', id:'dime', actionPerformed: controller.pay)
        button('Quarter', id:'quarter', actionPerformed: controller.pay)
        button('Dollar', id:'dollar', actionPerformed: controller.pay)
    }
    scrollPane(constraints:NORTH) {
        list(model: bind{model.inventoryListModel})
    }
    vbox(constraints:CENTER) {
        label('Choose Item:')
        textField(id:'code', text: bind('itemCode', target:model, id:'itemBinding'))
        button('VEND', id:'vend', actionPerformed: controller.vend)
        button('Coin Return', id:'coinReturn', actionPerformed: controller.coinReturn)
    }
    scrollPane(constraints:SOUTH) {
        label(id:'status', text: bind{model.status})
    }
}

doLater {
    vendingFrame.size = [300,300]
}