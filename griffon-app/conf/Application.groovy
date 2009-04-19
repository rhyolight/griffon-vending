application {
    title='VendingUi'
    startupGroups = ['vending-ui']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "vendingMaching"
    'vendingMaching' {
        model = 'VendingMachingModel'
        view = 'VendingMachingView'
        controller = 'VendingMachingController'
    }

    // MVC Group for "vending-ui"
    'vending-ui' {
        model = 'VendingUiModel'
        view = 'VendingUiView'
        controller = 'VendingUiController'
    }

}
