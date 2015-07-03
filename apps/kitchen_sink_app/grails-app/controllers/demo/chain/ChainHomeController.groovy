package demo.chain

class ChainHomeController {

    def demoChain(String ns) {
        chain controller: 'demo', action: 'doit', namespace: ns
    }
}
